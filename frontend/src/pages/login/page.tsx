import { InputField } from "@/widgets/form-components/fields"
import { LoginLayout } from "@/widgets/login-layout"
import { LockFilled, UserOutlined } from "@ant-design/icons"
import { Button, Checkbox, Form } from "antd"
import { useForm } from "effector-forms"
import styled from "styled-components"
import { $$form } from "./model"
import { useRouter } from "next/navigation"

export const LoginPage = () => {
  const { fields } = useForm($$form)
  const route = useRouter()
  const handleGoLogin = () => {
    route.push('/')
  }
  return (
    <LoginLayout>
      <FormWrapper>
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
                type="password"
                size="large"
                field={fields.password}
              />

              <Button type="primary" htmlType="submit" block style={{marginTop: '5%'}} onClick={handleGoLogin}>
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