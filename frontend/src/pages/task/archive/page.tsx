import { MainLayout } from "@/packages/main-layout"
import { ArchiveTable } from "@/packages/table/table"
import { $studentColumns  , $studentData, $lectorColumns, $lectorData } from "./model"
import { useUnit } from 'effector-react'
import { student } from "@/pages/login/model"

export const ArchiveTaskPage = () => {
  student.role = 'teacher'
  const $$columns = useUnit(student.role === 'teacher'? $lectorColumns : $studentColumns )
  const $$data = useUnit(student.role === 'teacher'? $lectorData : $studentData)
  return (
    <MainLayout>
        <ArchiveTable data={$$data} columns={$$columns} />
    </MainLayout>
  )
}
