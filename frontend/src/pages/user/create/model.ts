import { createForm } from "effector-forms"

export enum Role {
  ValueNotSelected = "Не выбран",
  ValueStudent = "Студент",
  ValueTeacher = "Преподователь"
}

export const $$form = createForm({
  fields: {
    login: {
      init: ""
    },
    password: {
      init: ""
    },
    firstName: {
      init: ""
    },
    surName: {
      init: ""
    },
    patronymic: {
      init: ""
    },
    DateBirth: {
      init: ""
    },
    group: {
      init: ""
    },
    role: {
      init: Role.ValueNotSelected as Role
    }
  }
})