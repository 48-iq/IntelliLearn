import { InputField, SelectField, enumToOptions } from "@/packages/form-components/fields"
import { LockFilled, UserOutlined } from "@ant-design/icons"
import { Button, Divider, Form } from "antd"
import { useForm } from "effector-forms"
import { $$form } from "./model"
import { Content } from "antd/es/layout/layout"
import styled from "styled-components"
import { Role } from './model'
import { TitleCustom } from "@/packages/title"

export const CreateUserPage = () => {
  const { fields } = useForm($$form)
  return (
    <Wrapper>
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
          <FlexContainer>
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
          </FlexContainer>

          <Divider orientation="left">Ваша роль</Divider>
          <SelectField 
            options={enumToOptions(Role)}
            field={fields.role}
            label="Роль"
            size="large"
          />
          <Button style={{marginTop: '5%'}} type="primary" block size="large">Обновить</Button>
        </Form>
      </MainContent>
    </Wrapper>
  )
}

const MainContent = styled(Content)`
  padding: 48px 48px;
  background-color: white;
  border-radius: 20px;
  max-width: 800px;
  margin: auto;
`
const Wrapper = styled.div`
  height: 100vh;
  width: 100%;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  background-image: url('../bgFormLogin.jpg');
  background-size: cover;
  background-position: center;
`
const FlexContainer = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
  > div {
    width: 48%;
  }
`