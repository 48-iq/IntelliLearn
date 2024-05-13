'use client'
import "./globals.css";
import { RouterProvider } from "react-router-dom";
import { router } from './routes'
import "./globals.css"
import { SessionProvider } from "@/packages/session/session-provider";

export default function RootLayout() {
  return (
    <html lang="en">
      <body>
        <SessionProvider>
          <RouterProvider router={router} />
        </SessionProvider>
      </body>
    </html>
  )
}
