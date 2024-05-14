import axios from "axios"
import { prefix } from "./shared"

const url = 'http://localhost:3000/'

export async function Login(args: {login: string, password: string}) {
  axios.request({
    url: `${prefix}/login`,
    method: 'post',
    data: args
  }).then((response) => response)
}

// export async function Login(args: {login: string, password: string}) {
//   axios.request({
//     url: `${prefix}/login`,
//     method: 'post',
//     data: args
//   }).then((response) => response)
// }

