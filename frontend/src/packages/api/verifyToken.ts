import { getCookie } from "cookies-next"
import jwt from 'jsonwebtoken'
import { AppRouterInstance } from "next/dist/shared/lib/app-router-context.shared-runtime"

export const verifyToken = (router: AppRouterInstance) => {
  const token = getCookie('token')
  const secretKey = 'my_secret_key'

  if (!token) {
    router.push('/loginasdads')
    console.log('token not found')
    return null
  }

  try {
    const decoded = jwt.verify(token, secretKey)
    console.log(decoded)
    return decoded;
  } catch (error) {
    console.log('token error', error)
    return null
  }
}
//eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxMjMsImlhdCI6MTcxNTYzNTYyOH0.qBI6qgth9P12lWpnhnaYZFgYJPTziAtJ4PhUgr5bq64