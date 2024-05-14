import { List } from "antd";
import { createForm } from "effector-forms";

export enum FaceOnCaseEnum {
  ValueНеВыбран = "Не выбран",
  ValueОтветчик = "ответчик",
  ValueТретьеЛицо = "третье лицо",
}

export const $$form = createForm({
  fields: {
    task1: {
      init: ''
    },
    task2: {
      init: ''
    },
    task3: {
      init: ''
    },
    task4: {
      init: ''
    },
    task5: {
      init: ''
    },
    task6: {
      init: ''
    },
    task7: {
      init: ''
    },
    task8: {
      init: ''
    },
    task9: {
      init: ''
    },
    task10: {
      init: ''
    },
    task11: {
      init: ''
    },
    task12: {
      init: ''
    },
    task13: {
      init: ''
    },
    task14: {
      init: ''
    },
    task15: {
      init: ''
    },
    type15: {
      init: ''
    },
    // group: { 
    //   init: FaceOnCaseEnum
    // }
  }
})