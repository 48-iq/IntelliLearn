import { MainLayout } from "@/packages/main-layout"
import { ArchiveTable } from "@/packages/table/table"
import { $columnsStore, $dataStore } from "./model"
import { useUnit } from 'effector-react'
import { student } from "@/pages/login/model"

export const ArchiveTaskPage = () => {
  const $$columns = useUnit($columnsStore)
  const $$data = useUnit($dataStore)
  return (
    <MainLayout>
      { student.role === 'teacher' ? (
        <ArchiveTable data={$$data} columns={$$columns} />
      ) : (
        <ArchiveTable data={$$data} columns={$$columns} />
      )}
    </MainLayout>
  )
}
