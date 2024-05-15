import axios from "axios"
import { prefix } from "./shared"
import { setCookie } from "cookies-next"

export async function login(args: {userName: string, password: string}) {
  try {
    const response = await axios.post(`http://localhost:8080/${prefix}/register`, args)
    const token = response.data.token
    setCookie('token', token)
    return response
  } catch (error) {
    console.error('Ошибка при регистрации:', error)
    throw error
  }
}

export async function registration(args: {userName: string, password: string, name: string, surName: string, groupName: string, role: string}) {
  try {
    const response = await axios.post(`http://localhost:8080/${prefix}/register`, args)
    const token = response.data.token
    setCookie('token', token)
    return response
  } catch (error) {
    console.error('Ошибка при регистрации:', error)
    throw error
  }
}

