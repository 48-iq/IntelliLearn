import { Card } from "antd"

export const Notification = () => {
  const notification = [
    { 
      id: 1,
      prepod: 'Преподаватель',
      message: 'Должник',
    },
    { 
      id: 2,
      prepod: 'Преподаватель',
      message: 'Автомат',
    },
    { 
      id: 3,
      prepod: 'Преподаватель',
      message: 'Персдача в 12.00',
    },
    { 
      id: 4,
      prepod: 'Преподаватель',
      message: 'Подойдите 15.05 в 10.30',
    },
    { 
      id: 5,
      prepod: 'Преподаватель',
      message: 'Пересдача завтра!',
    },
  ]
  return (
    <>
      {notification.map((notification) => (
        <Card
          key={notification.id}
          title={notification.prepod}
          style={{marginTop: '1%'}}
        >
          {notification.message}
        </Card>
      ))}
    </>
  )
}
