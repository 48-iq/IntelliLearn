import { Typography } from "antd"
import { ReactNode } from "react"
import styled from "styled-components"

const { Title } = Typography

interface TitleCustomProps {
  children: ReactNode,
  level?: 1 | 2 | 3 | 4 | 5
}
export const TitleCustom = ({ children, level }: TitleCustomProps) => {
  return (
    <BlueTitle level={level}>
      {children}
    </BlueTitle>
  )
}

const BlueTitle = styled(Title)`
  border-left: 5px solid #1677FF;
  padding-left: 1%;
`
