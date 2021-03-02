package telegram

import (
	"context"

	tgBotApi "github.com/go-telegram-bot-api/telegram-bot-api"
	"github.com/pkg/errors"
)

const defaultParseMode = tgBotApi.ModeHTML

// Telegram struct holds necessary data to communicate with the Telegram API.
type Telegram struct {
	client  *tgBotApi.BotAPI
	chatIds []int64
}

// New returns a new instance of a Telegram notification service.
// For more information about telegram api token:
//    -> https://pkg.go.dev/github.com/go-telegram-bot-api/telegram-bot-api#NewBotAPI
func New(apiToken string) (*Telegram, error) {
	client, err := tgBotApi.NewBotAPI(apiToken)
	if err != nil {
		return nil, err
	}

	t := &Telegram{
		client:  client,
		chatIds: []int64{},
	}

	return t, nil
}

// AddReceivers takes Telegram chat IDs and adds them to the internal chat ID list. The Send method will send
// a given message to all those chats.
func (t *Telegram) AddReceivers(chatIds ...int64) {
	t.chatIds = append(t.chatIds, chatIds...)
}

// Send takes a message subject and a message body and sends them to all previously set chats. Message body supports
// html as markup language.
func (t Telegram) Send(ctx context.Context, subject, message string) error {
	fullMessage := subject + "\n" + message // Treating subject as message title

	msg := tgBotApi.NewMessage(0, fullMessage)
	msg.ParseMode = defaultParseMode

	for _, chatId := range t.chatIds {
		select {
		case <-ctx.Done():
			return ctx.Err()
		default:
			msg.ChatID = chatId
			_, err := t.client.Send(msg)
			if err != nil {
				return errors.Wrapf(err, "failed to send message to Telegram chat '%d'", chatId)
			}
		}
	}

	return nil
}
