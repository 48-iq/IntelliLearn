import { MainLayout } from "@/packages/main-layout"
import { ArchiveTable } from "@/packages/table/table"
import { $columnsStore, $dataStore } from "./model"
import { useUnit } from 'effector-react'

export const ArchiveTaskPage = () => {
  const $$columns = useUnit($columnsStore)
  const $$data = useUnit($dataStore)
  return (
    <MainLayout>
      <ArchiveTable data={$$data} columns={$$columns} />
    </MainLayout>
  )
}
