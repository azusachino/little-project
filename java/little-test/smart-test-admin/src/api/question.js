import request from '../utils/request'

export function fetchList(questParam) {
  return request.get('/question', {params: questParam})
}

export function del(questionId) {
  return request.delete(`/question/${questionId}`)
}

export function update(question) {
  return request.put(`/question`, {
    question
  })
}
