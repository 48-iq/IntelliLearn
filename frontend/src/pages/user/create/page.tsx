import { InputField, SelectField, enumToOptions } from "@/packages/form-components/fields"
import { LockFilled, UserOutlined } from "@ant-design/icons"
import { Button, Divider, Flex, Form, Space, } from "antd"
import { useForm } from "effector-forms"
import { $$form } from "./model"
import { Content } from "antd/es/layout/layout"
import styled from "styled-components"
import { Role } from './model'
import { TitleCustom } from "@/packages/title"

export const CreateUserPage = () => {
  const { fields } = useForm($$form)
  return(
    <ContentContainer>
      <MainContent>
        <TitleCustom>Регистрация</TitleCustom>
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
          <Divider orientation="left">Личные данные</Divider>
          <Flex justify="space-between">
            <div>
              <InputField
                label={'Имя'}
                addonBefore={<UserOutlined />}
                size="large"
                field={fields.firstName}
              />

              <InputField
                label={'Фамилия'}
                addonBefore={<LockFilled />}
                size="large"
                field={fields.surName}
              />
            </div>
            <div>
              <InputField
                label={'Отчество'}
                addonBefore={<UserOutlined />}
                size="large"
                field={fields.patronymic}
              />

              <InputField
                label={'Группа'}
                addonBefore={<LockFilled />}
                size="large"
                field={fields.group}
              />
            </div>
        
          </Flex>

          <Divider orientation="left">Ваша роль</Divider>
          <SelectField 
            options={enumToOptions(Role)}
            field={fields.role}
            label="Роль"
            size="large"
          />
          <Button style={{marginTop: '5%'}} type="primary" block>Обновить</Button>
        </Form>
      </MainContent>
    </ContentContainer>
  )
}

const MainContent = styled(Content)`
  padding: 48px 48px;
  width: 50%;
  background-color: white;
  border-radius: 20px;
  margin: auto;
  min-height: 600px;
`
const ContentContainer = styled.div`
  padding: 24px;
  background-color: #E0DCDC;  
`