import axios from 'axios'

export const $api = axios.create({
  withCredentials: true,
  baseURL: 'url'
})

$api.interceptors.request.use((config) => {
  config.headers.Authorization = `Bearer ${localStorage.getItem('token')}`
  return config
})