import { InputField, SelectField, enumToOptions } from "@/packages/form-components/fields"
import { LockFilled, UserOutlined, UsergroupAddOutlined } from "@ant-design/icons"
import { Button, Divider, Form, notification } from "antd"
import { useForm } from "effector-forms"
import { $$form, Role } from "./model"
import { Content } from "antd/es/layout/layout"
import styled from "styled-components"
import { TitleCustom } from "@/packages/title"
import { LoginEntity } from "@/entities/login"
import { setCookie } from "cookies-next"
import { useRouter } from "next/navigation"

export const CreateUserPage = () => {
  const { fields } = useForm($$form)
  const router = useRouter()
  const onFinish = async () => {
    try{
      const response = await LoginEntity.api.rest.registration({
        userName: fields.userName.value,
        password: fields.password.value,
        name: fields.name.value,
        surName: fields.surName.value,
        groupName: fields.groupName.value,
        role: fields.role.value
      })
      router.push('//')
      setCookie('token', response)
      notification.success({message: 'Вход', placement: 'bottomRight'})
    } catch (e){
      console.log(e)
      notification.error({message: 'Ошибка', placement: 'bottomRight'})
    }
  }
  return (
    <Wrapper>
      <MainContent>
        <TitleCustom>Регистрация</TitleCustom>
        <Form onFinish={onFinish}>
          <InputField
            label={'Логин'}
            addonBefore={<UserOutlined />}
            size="large"
            field={fields.userName}
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
                field={fields.name}
              />

              <InputField
                label={'Фамилия'}
                addonBefore={<UserOutlined />}
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
                addonBefore={<UsergroupAddOutlined />}
                size="large"
                field={fields.groupName}
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
          <Button style={{marginTop: '5%'}} type="primary" htmlType="submit" block size="large">Зарегистрироваться</Button>
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