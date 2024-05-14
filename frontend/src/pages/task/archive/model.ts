import { createStore } from "effector"

export const $columnsStore = createStore([
  {
    title: 'Задача',
    dataIndex: 'task',
    key: 'task',
  },
  {
    title: 'Предмет',
    dataIndex: 'subject',
    key: 'subject',
  },
  {
    title: 'Период',
    dataIndex: 'period',
    key: 'period',
  },
  {
    title: 'Преподаватель',
    dataIndex: 'prepod',
    key: 'prepod',
  },
])

export const $dataStore = createStore([
  { id: 1, task: 'Летучка', subject: 'Архитектура приложений', period: '13-15', prepod: 'Преподаватель'},
  { id: 2, task: 'Лабораторная работа 2', subject: 'Технологии программирования', period: '12-15', prepod: 'Преподаватель' },
  { id: 3, task: 'Летчку 3', subject: 'Веб разработка', period: '12-20', prepod: 'Преподаватель'},
])
