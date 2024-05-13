import axios from "axios"

const url = 'http/example.com '


export async function Login(args: {login: string, password: string}) {
  axios.request({
    url: url,
    method: 'post',
    data: args
  }).then((response) => response)
}