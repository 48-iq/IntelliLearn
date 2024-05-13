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
      link: '/loginasdads'
    }
  ]

  const items = menuItems.map(item => (
    <Menu.Item key={item.key}>
      <Link to={item.link}>{item.label}</Link>
    </Menu.Item>
  ))
  
  return (
    <Layout>
      <Header
        style={{
          position: 'sticky',
          top: 0,
          zIndex: 1,
          width: '100%',
          display: 'flex',
          alignItems: 'center',
        }}
      >
        <Menu 
          theme="dark"
          mode="horizontal"
        >
          {items}
        </Menu>
      </Header>
      <MainContent>
        <ContentContainer>
          {children}
        </ContentContainer>
      </MainContent>
      <Footer>create by deadline destroyers © {new Date().getFullYear()}</Footer>
    </Layout>
  )
}

const MainContent = styled(Content)`
  padding: 48px 48px;
`
const ContentContainer = styled.div`
  padding: 24px;
  min-height: 600px;
  background-color: white;
  border-radius: 20px;
`