package littleNotify

import (
	"context"
	"github.com/pkg/errors"
	"golang.org/x/sync/errgroup"
)

const defaultDisabled = false

var ErrSendNotification = errors.New("send notification")

// Notifier defines the behaviour of notification services.
type Notifier interface {
	// send subject to the internal destination Notifier
	Send(context.Context, string, string) error
}

// Notify is the central struct for managing notification services and sending messages to them.
type Notify struct {
	Disabled  bool
	notifiers []Notifier
}

func New() *Notify {
	notify := &Notify{
		Disabled:  defaultDisabled,
		notifiers: []Notifier{},
	}
	return notify
}

func (n Notify) Send(ctx context.Context, subject, message string) error {
	if n.Disabled {
		return nil
	}
	var eg errgroup.Group

	for _, service := range n.notifiers {
		if service != nil {
			s := service
			eg.Go(func() error {
				return s.Send(ctx, subject, message)
			})
		}
	}

	err := eg.Wait()
	if err != nil {
		err = errors.Wrap(ErrSendNotification, err.Error())
	}

	return err
}

// UseServices adds the given service(s) to the Notifier's services list.
func (n *Notify) UseServices(service ...Notifier) {
	for _, s := range service {
		n.useService(s)
	}
}

// useService adds a given service to the Notifier's services list.
func (n *Notify) useService(service Notifier) {
	if service != nil {
		n.notifiers = append(n.notifiers, service)
	}
}
