import { getCookie } from "cookies-next"
import jwt from 'jsonwebtoken'
import { AppRouterInstance } from "next/dist/shared/lib/app-router-context.shared-runtime"

export const verifyToken = (router: AppRouterInstance) => {
  const token = getCookie('token')
  const secretKey = '1234'

  if (!token) {
    router.push('/auth/login')
    console.log('token not found')
    return null
  }

  try {
    const decoded = jwt.verify(token, secretKey)
    return decoded
  } catch (error) {
    return null
  }
}