import { createForm } from "effector-forms";

export const $$form = createForm({
  fields: {
    login: {
      init: ""
    },
    password: {
      init: ""
    }
  }
})

export const  student = {
  login: 'Давид',
  password: '251315ru',
  role: 'student'
}