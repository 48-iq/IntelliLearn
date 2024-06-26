import { MainLayout } from "@/packages/main-layout"
import { ProgressBarComponent } from "@/widgets/progress-bar/ui"
import { Divider, Space, Tabs, TabsProps } from "antd"
import { Notification } from '@/widgets/notification'

export const DashboardPage = () => {
  
  const items: TabsProps['items'] = [
    {
      key: '1',
      label: 'Математика',
      children: <ProgressBarComponent procent={0.45} id="1"/>,
    },
    {
      key: '2',
      label: 'Алгоритмы и структура данных',
      children: <ProgressBarComponent procent={0.32} id="2"/>,
    },
    {
      key: '3',
      label: 'Архитектура информационных систем',
      children: <ProgressBarComponent procent={0.78} id="3"/>,
    },
    {
      key: '4',
      label: 'Информационные технологии',
      children: <ProgressBarComponent procent={0.24} id="4"/>,
    },
    {
      key: '5',
      label: 'Современные технологии управления базами данных',
      children: <ProgressBarComponent procent={1} id="5"/>,
    },
    {
      key: '6',
      label: 'Нереляционные базы данных',
      children: <ProgressBarComponent procent={0.49} id="6"/>,
    },
    {
      key: '7',
      label: 'Игровые виды спорта',
      children: <ProgressBarComponent procent={0.54} id="7"/>,
    },
    {
      key: '8',
      label: 'Администрирование информационных систем',
      children: <ProgressBarComponent procent={0.68} id="8"/>,
    },
  ]

  return (
    <MainLayout>
        <Tabs defaultActiveKey="1" items={items}/><br />
        <Divider orientation="left">Уведомления</Divider>
        <Notification />
    </MainLayout>
  )
}
