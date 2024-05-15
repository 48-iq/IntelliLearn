import { LoginEntity } from "@/entities/login"
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

export const onFinish = () => {
  try{
    LoginEntity.api.rest.registration({dto: $$form.$values})
  } catch(error) {
    console.log(error)
  }
}