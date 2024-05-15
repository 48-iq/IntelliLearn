import { InputField } from "@/packages/form-components/fields"
import { MainLayout } from "@/packages/main-layout"
import { LockFilled, UserOutlined } from "@ant-design/icons"
import { Button, Card, Flex, Form, Image, Tabs, TabsProps } from 'antd'
import { useForm } from "effector-forms"
import { styled } from "styled-components"
import { $$form } from "./model"

export const SingleUserPage = () => {
  const { fields } = useForm($$form)

  const items: TabsProps['items'] = [
    {
      key: '1',
      label: 'Математика',
      children: "К 16.05.2024 нужно решить 2 задачи",
    },
    {
      key: '2',
      label: 'Алгоритмы и структура данных',
      children: "Написать программу до 01.06.2024",
    },
    {
      key: '3',
      label: 'Архитектура информационных систем',
      children: "Все сдано",
    },
    {
      key: '4',
      label: 'Информационные технологии',
      children: 'Подготовиться к экзамену 03.06.2024',
    },
    {
      key: '5',
      label: 'Современные технологии управления базами данных',
      children: 'Все сдано',
    },
    {
      key: '6',
      label: 'Нереляционные базы данных',
      children: 'Спроектировать собственную базу данных согласно вашему варианту',
    },
    {
      key: '7',
      label: 'Игровые виды спорта',
      children: 'Все сдано',
    },
    {
      key: '8',
      label: 'Администрирование информационных систем',
      children: 'Написать билдер, описанный в формате gitlab ci (.gitlab-ci.yml)',
    },
  ]

  return (
    <MainLayout>
      <Wrapper>
        <LeftTab>
          <ImgWrapper>
            <CircleImg src="../profileIcon.jpeg"/>
          </ImgWrapper>
          <MetaData> 
            <Tabs defaultActiveKey="1" items={items}/>
          </MetaData>
        </LeftTab>
        <RightTab>
          <UserDataInfo>
            <Form>
              <InputField
                label={'Логин'}
                addonBefore={<UserOutlined />}
                size="large"
                field={fields.login}
              />
              <InputField
                label={'Пароль'}
                addonBefore={<LockFilled />}
                size="large"
                field={fields.password}
              />

              <Button style={{marginTop: '5%'}} type="primary" block>Обновить</Button>
            </Form>
          </UserDataInfo>
        </RightTab>
      </Wrapper>
    </MainLayout>
  )
}

const Wrapper = styled.div`
  display: flex;
  justify-content: space-between;
`
const CircleImg = styled(Image)`
  border-radius: 80%;
`
const ImgWrapper = styled.div`
  width: 50%;
`
const MetaData = styled(Card)`
  margin-top: 10%;
`
const LeftTab = styled.div`
  width: 45%;
`
const RightTab = styled.div`
  width: 45%;
`
const UserDataInfo = styled(Card)`
  min-height: 100%;
`