import React, { ReactNode, createContext, useContext, useEffect, useState } from 'react'
import { verifyToken } from '../api/verifyToken'
import { JwtPayload } from 'jsonwebtoken'
import { useRouter } from 'next/navigation'

const SessionContext = createContext<JwtPayload | null>(null)

export const useSession = () => useContext(SessionContext)

interface SessionProviderProps {
  children: ReactNode
}

export const SessionProvider = ({ children }: SessionProviderProps) => {
  const router = useRouter()
  const [session, setSession] = useState<JwtPayload | null>(null)

  useEffect(() => {
    
    const userInfo = verifyToken(router)
    if (typeof userInfo === 'object' && userInfo !== null) {
      setSession(userInfo)
    }
  }, [])

  return (
    <SessionContext.Provider value={session}>
      {children}
    </SessionContext.Provider>
  )
}
