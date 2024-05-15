import { createStore } from "effector"

export const $studentColumns = createStore([
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

export const $studentData = createStore([
  { id: 1, task: 'Летучка', subject: 'Архитектура приложений', period: '13-15', prepod: 'Преподаватель'},
  { id: 2, task: 'Лабораторная работа 2', subject: 'Технологии программирования', period: '12-15', prepod: 'Преподаватель' },
  { id: 3, task: 'Летчку 3', subject: 'Веб разработка', period: '12-20', prepod: 'Преподаватель'},
])


export const $lectorColumns = createStore([
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
    dataIndex: 'period',
    key: 'period',
  },
])

export const $lectorData = createStore([
  { id: 1, task: 'Летучка', subject: 'Архитектура приложений', period: '13-15', prepod: 'Группа'},
  { id: 2, task: 'Лабораторная работа 2', subject: 'Технологии программирования', period: '12-15', prepod: 'Группа' },
  { id: 3, task: 'Летчку 3', subject: 'Веб разработка', period: '12-20', prepod: 'Группа'},
])
