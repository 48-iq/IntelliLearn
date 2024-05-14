import { InputField } from "@/packages/form-components/fields"
import { MainLayout } from "@/packages/main-layout"
import { LockFilled, UserOutlined } from "@ant-design/icons"
import { Button, Card, Flex, Form, Image, Tabs, TabsProps } from 'antd'
import { styled } from "styled-components"

export const SingleUserPage = () => {
    
  const items: TabsProps['items'] = [
    {
      key: '1',
      label: 'Предмет 1',
      children: 'Meta Data'
    },
    {
      key: '2',
      label: 'Предмет 2',
      children: 'Meta Data'
    },
    {
      key: '3',
      label: 'Предмет 3',
      children: 'Meta Data'
    },
  ]

  return (
    <MainLayout>
      <Wrapper>
        <LeftTab>
          <ImgWrapper>
            <CircleImg src="https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png"/>
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
              />
              <InputField
                label={'Пароль'}
                addonBefore={<LockFilled />}
                size="large"
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