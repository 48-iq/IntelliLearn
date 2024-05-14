import { MainLayout } from "@/packages/main-layout"
import { Button, Divider, Form, Input, Select, Space, DatePicker, GetProps, DatePickerProps, Flex } from "antd"
import { useState } from "react"
import React from "react"
import { TitleCustom } from "@/packages/title"

type RangePickerProps = GetProps<typeof DatePicker.RangePicker>
const { RangePicker } = DatePicker

export const CreateTaskPage = () => {
  const [questionList, setQuestionList] = useState<{ question: string; responses: string[] }[]>([])
  const [nameTask, setNameTask] = useState('')
  const [nameGroup, setNameGroup] = useState<string[]>([])
  const [selectedDates, setSelectedDates] = useState<{ start: string; end: string[] }[]>([])

  const options = ['группа 1','группа 2', 'группа 3', 'группа 4', 'группа 5']
  const filteredOptions = options.filter((o) => !nameGroup.includes(o))
  
  const addQuestion = () => {
    setQuestionList([...questionList, { question: '', responses: [] }])
  }

  const handleQuestionChange = (index: number, value: string) => {
    const updatedQuestionList = [...questionList]
    updatedQuestionList[index].question = value
    setQuestionList(updatedQuestionList)
  }

  const addResponse = (questionIndex: number) => {
    const updatedQuestionList = [...questionList]
    updatedQuestionList[questionIndex].responses.push('')
    setQuestionList(updatedQuestionList)
  }

  const handleResponseChange = (questionIndex: number, responseIndex: number, value: string) => {
    const updatedQuestionList = [...questionList]
    updatedQuestionList[questionIndex].responses[responseIndex] = value
    setQuestionList(updatedQuestionList)
  }

  const onOk = (value: [start: any, end: any]) => {
    setSelectedDates(value)
  }

  const removeQuestion = (index: number) => {
    const updatedQuestionList = [...questionList]
    updatedQuestionList.splice(index, 1)
    setQuestionList(updatedQuestionList)
  }

  const removeResponse = (questionIndex: number, responseIndex: number) => {
    const updatedQuestionList = [...questionList]
    updatedQuestionList[questionIndex].responses.splice(responseIndex, 1)
    setQuestionList(updatedQuestionList)
  }

  const handleSubmit = () => {
    const information = {
      nameTask: nameTask,
      nameGroup: nameGroup,
      questionList: questionList,
      period: selectedDates
    }
    console.log(information)
  }

  return (
    <MainLayout>
      <Form onFinish={handleSubmit} style={{ width: '60%', marginLeft: '20%'}}>
        <TitleCustom>Создание теста</TitleCustom><br />

        <Divider orientation="left">Группа и сроки</Divider>
        <Space direction="vertical" size={20} style={{width: '100%'}}>
          <Flex style={{width: '100%'}} justify="space-between" >
            <Select
              mode="multiple"
              placeholder="Выберите группу"
              value={nameGroup}
              onChange={setNameGroup}
              style={{ width: '95%' }}
              options={filteredOptions.map((item) => ({
                value: item,
                label: item,
              }))}
              size="large" 
            />
            <RangePicker 
              showTime={{ format: 'HH:mm' }}
              format="YYYY-MM-DD HH:mm"
              size="large"
              onOk={onOk}
              style={{ width: "95%", marginLeft: '5%' }}
            />
          </Flex>
        </Space>
        <Divider orientation="left">Название задачи</Divider>
        <Input onChange={(e) => setNameTask(e.target.value)} size="large" />
        {questionList.map((question, questionIndex) => (
          <div key={questionIndex}>
            <Divider />
            <TitleCustom level={5}>Задание {`${questionIndex}`}</TitleCustom>
            <Input
              value={question.question}
              onChange={(e) => handleQuestionChange(questionIndex, e.target.value)}
              size="large"
            />
            <Space direction="vertical">
            <Button type="link" onClick={() => removeQuestion(questionIndex)}>
              Удалить задание
            </Button>
            {question.responses.map((response, responseIndex) => (
              <React.Fragment key={`${questionIndex}_${responseIndex}`}>
                <TitleCustom level={5}>Ответ {`${responseIndex}`}</TitleCustom>
                <Input
                  value={response}
                  onChange={(e) => handleResponseChange(questionIndex, responseIndex, e.target.value)}
                  size="large"
                />
                <Button type="link" onClick={() => removeResponse(questionIndex, responseIndex)}>
                  Удалить ответ
                </Button>
              </React.Fragment>
            ))}
            <Button type="primary" onClick={() => addResponse(questionIndex)} style={{marginTop: '5%'}}>
              Добавить ответ
            </Button>
            </Space>
          </div>
        ))}
        <div style={{marginTop: '5%'}}>
          <Button type="primary" onClick={addQuestion} block>
            Добавить задание
          </Button>
          <Form.Item style={{marginTop: '5%'}}>
            <Button type="primary" htmlType="submit" block>
              Сохранить
            </Button>
          </Form.Item>
        </div>
      </Form>
    </MainLayout>
  )
}
