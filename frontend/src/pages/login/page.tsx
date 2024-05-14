import { InputField } from "@/packages/form-components/fields"
import { LoginLayout } from "@/packages/login-layout"
import { LockFilled, UserOutlined } from "@ant-design/icons"
import { Button, Form } from "antd"
import { useForm } from "effector-forms"
import styled from "styled-components"
import { $$form } from "./model"
import { useRouter } from "next/navigation"
import { LoginEntity } from "@/entities/login"

export const LoginPage = () => {
  const { fields } = useForm($$form)
  const route = useRouter()

  const onFinish = () => {
    LoginEntity.api.rest.Login({
      login: fields.login.value,
      password: fields.password.value
    })
    // notification.success({message: 'Вход', placement: 'bottomRight'})
    route.push('/')
  }

  return (
    <LoginLayout>
      <FormWrapper>
          <Form onFinish={onFinish}>
              <InputField 
                label={'Логин'}
                addonBefore={<UserOutlined />}
                size="large"
                field={fields.login}
              />

              <InputField 
                label={'Пароль'}
                addonBefore={<LockFilled />}
                type="password"
                size="large"
                field={fields.password}
              />

              <Button type="primary" htmlType="submit" block style={{marginTop: '5%'}}>
                Войти
              </Button>
          </Form>         
        </FormWrapper>
    </LoginLayout>
  )
} 
const FormWrapper = styled.div`
  margin-left: 15%;
  width: 70%;
`