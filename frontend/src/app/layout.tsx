'use client'
import "./globals.css";
import { RouterProvider } from "react-router-dom";
import { router } from './routes'

export default function RootLayout(){
  return (
    <html lang="en">
      <body><RouterProvider router={router} /></body>
    </html>
  )
}
