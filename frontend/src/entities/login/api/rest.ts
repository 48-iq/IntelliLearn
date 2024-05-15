import axios from "axios"
import { prefix } from "./shared"

const url = 'http://localhost:8080'

interface UserDto {
  username?: string 
  password?: string 
  email?: string 
  name?: string 
  surname?: string 
  patronymic?: string 
  birthday?: string 
  role?: string
}

export async function login(args: {login: string, password: string}) {
  axios.request({
    url: `${url}/${prefix}/login`,
    method: 'post',
    data: args
  }).then((response) => response)
}

export async function registration(args: {dto: UserDto}) {
  axios.request({
    url: `${url}/${prefix}/register`,
    method: 'post',
    data: args.dto
  }).then((response) => response)
}

