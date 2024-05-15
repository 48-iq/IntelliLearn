import { Card } from "antd"

export const Notification = () => {
  const notification = [
    { 
      id: 1,
      prepod: 'Преподаватель',
      message: 'Завтра 16.05.2024 летучка',
    },
    { 
      id: 2,
      prepod: 'Преподаватель',
      message: 'По математике у вас автомат',
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
        <div >
          <Card
            key={notification.id}
            title={notification.prepod}
            style={{marginTop: '1%'}}
            hoverable={true} 
          >
            {notification.message}
          </Card>
        </div>
      ))}
    </>
  )
}
