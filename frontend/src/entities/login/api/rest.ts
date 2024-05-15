import axios from "axios"
import { prefix } from "./shared"

const url = 'http://localhost:8080'

export async function login(args: {login: string, password: string}) {
  axios.request({
    url: `${url}/${prefix}/login`,
    method: 'post',
    data: args
  }).then((response) => response)
}

export async function registration(args: {userName: string, password: string, name: string, surName: string, groupName: string, role: string}) {
  axios.request({
    url: `${url}/${prefix}/register`,
    method: 'post',
    data: args
  }).then((response) => response)
}

