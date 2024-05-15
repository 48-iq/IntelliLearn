import { LoginEntity } from "@/entities/login"
import { createForm } from "effector-forms"

export enum Role {
  ValueNotSelected = "Не выбран",
  ValueStudent = "Студент",
  ValueTeacher = "Преподователь"
}

export const $$form = createForm({
  fields: {
    userName: {
      init: ""
    },
    password: {
      init: ""
    },
    name: {
      init: ""
    },
    surName: {
      init: ""
    },
    patronymic: {
      init: ""
    },
    groupName: {
      init: ""
    },
    role: {
      init: Role.ValueNotSelected as Role
    }
  }
})
