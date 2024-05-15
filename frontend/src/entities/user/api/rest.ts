import axios from "axios"
import { prefix } from "./shared"


export async function getOneById(args: {login: string, password: string}) {
  axios.request({
    url: `${prefix}/login`,
    method: 'post',
    data: args
  }).then((response) => response)
}

export async function getAll(args: {login: string, password: string}) {
  axios.request({
    url: `${prefix}/register`,
    method: 'post',
    data: args
  }).then((response) => response)
}