import { Content } from "antd/es/layout/layout"
import { ReactNode } from "react"
import styled from "styled-components"

interface LoginLayoutProps {
  children: ReactNode
}

export const LoginLayout = ({children}: LoginLayoutProps) => {

  return (
    <Wrapper>
      <PhotoPreview>
      <img src={'../loginbg.jpg'} style={{borderRadius: '40%'}}/>
      </PhotoPreview>
      <Content>
        {children}
      </Content>
    </Wrapper>
  )
}

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
const PhotoPreview = styled.div`
  height: 80%;
  width: 75%;
  max-width: 810px;
  display: flex;
  > img {
    width: 100%;
  }
  border-radius: 40%;
`