import { Menu } from "antd"
import Layout, { Content, Footer, Header } from "antd/es/layout/layout"
import { ReactNode } from "react"
import { Link } from "react-router-dom"
import styled from "styled-components"

interface MainLayotProps {
  children: ReactNode
}

export const MainLayout = ({children}: MainLayotProps) => {

  const menuItems = [
    {
      key: '1',
      label: 'Домашняя страница',
      link: '/'
    },
    {
      key: '2',
      label: 'Логин',
      link: '/auth/login'
    },
    {
      key: '3',
      label: 'сингл юзер',
      link: '/users/user'
    },
    {
      key: '4',
      label: 'Создать задачу',
      link: '/create/task'
    },
    {
      key: '5',
      label: 'Регестрация',
      link: '/auth/registration'  
    },
    {
      key: '6',
      label: 'Задания',
      link: '/tasks'  
    }
  ]

  const items = menuItems.map(item => (
    <Menu.Item key={item.key}>
      <Link to={item.link}>{item.label}</Link>
    </Menu.Item>
  ))
  
  return (
    <Layout>
      <HeaderCustom>
        <Logo src="/logo.png" />
          <Menu 
            mode="horizontal"
            style={{width: '42%', marginLeft: '22%', backgroundColor: '#F5F5F5'}}
          >
            {items}
          </Menu>
      </HeaderCustom>
      <MainContent>
        <ContentContainer>
          {children}
        </ContentContainer>
      </MainContent>
      <Footer style={{color: '#1677FF', fontSize: '15px'}}>create by deadline destroyers © {new Date().getFullYear()}</Footer>
    </Layout>
  )
}

const HeaderCustom = styled(Header)`
  position: sticky;
  top: 0;
  z-index: 999999;
  width: 100%;
  display: flex;
  align-items: center;
  background-color: #F5F5F5;
  margin: auto;
` 
const MainContent = styled(Content)`
  padding: 48px 48px;
`
const ContentContainer = styled.div`
  padding: 24px;
  min-height: 600px;
  background-color: white;
  border-radius: 20px;
`
const Logo = styled.img`
  width: 5%;
  height: 100%;
  margin-left: 2%;
`