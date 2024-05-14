import React from 'react'
import { Table } from 'antd'
import type { ColumnType } from 'antd/es/table/interface'
import { AnyObject } from 'antd/es/_util/type'
import { useRouter } from 'next/navigation'

type ArchiveTableProps<DataItem> = {
  data: DataItem[]
  columns: ColumnType<DataItem>[]
}

export function ArchiveTable<DataItem extends AnyObject>({ data, columns }: ArchiveTableProps<DataItem>) {
  const router = useRouter()
  const handleRowDoubleClick = (record: DataItem) => {
    const id = record.id
    router.push(`/tasks/task/${id}`)
    console.log(record)
  }
  
  return (
    <Table<DataItem>
      dataSource={data} 
      columns={columns} 
      onRow={(record) => ({
        onDoubleClick: () => handleRowDoubleClick(record)
      })}
    />
  )
}
