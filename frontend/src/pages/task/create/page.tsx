import { MainLayout } from "@/packages/main-layout"
import { Button, Divider, Form, Input, Select, Space, DatePicker, Flex, Radio } from "antd"
import { useState } from "react"
import React from "react"
import { TitleCustom } from "@/packages/title"

const { RangePicker } = DatePicker

export const CreateTaskPage = () => {
  const [questionList, setQuestionList] = useState<{ question: string; responses: string[]; correctAnswerIndex: number | null }[]>([])
  const [selectedDates, setSelectedDates] = useState<{ start: string; end: string[] }[]>([])
  const [nameGroup, setNameGroup] = useState<string[]>([])
  const [nameTask, setNameTask] = useState('')

  const options = ['группа 1','группа 2', 'группа 3', 'группа 4', 'группа 5']
  const filteredOptions = options.filter((o) => !nameGroup.includes(o))
  
  const addQuestion = () => {
    setQuestionList([...questionList, { question: '', responses: [], correctAnswerIndex: null }])
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
  
  const handleCorrectAnswerChange = (questionIndex: number, responseIndex: number) => {
    const updatedQuestionList = [...questionList]
    updatedQuestionList[questionIndex].correctAnswerIndex = responseIndex
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
        <Divider orientation="left">Название Теста</Divider>
        <Input onChange={(e) => setNameTask(e.target.value)} size="large" />
        {questionList.map((question, questionIndex) => (
          <div key={questionIndex}>
            <Divider orientation="left">Задание {`${questionIndex + 1}`}</Divider>
            <Input
              value={question.question}
              onChange={(e) => handleQuestionChange(questionIndex, e.target.value)}
              size="large"
              placeholder={`Задание ${questionIndex + 1}`}
            />
            <Space direction="vertical">
            <Button type="link" onClick={() => removeQuestion(questionIndex)}>
              Удалить задание
            </Button>
            {question.responses.map((response, responseIndex) => (
              <React.Fragment key={`${questionIndex}_${responseIndex}`}>
                <Divider orientation="left">Ответ {`${responseIndex + 1}`}</Divider>
                <Space>
                  <Input
                    value={response}
                    onChange={(e) => handleResponseChange(questionIndex, responseIndex, e.target.value)}
                    size="large"
                    placeholder={`Ответ ${responseIndex }`}
                  />
                    <Radio
                      checked={question.correctAnswerIndex === responseIndex}
                      onChange={() => handleCorrectAnswerChange(questionIndex, responseIndex)}
                    >
                    Отметить как правильный ответ
                  </Radio>
                </Space>
                <Button type="link" onClick={() => removeResponse(questionIndex, responseIndex)}>
                  Удалить вариант ответа
                </Button>
              </React.Fragment>
            ))}
            <Button type="primary" onClick={() => addResponse(questionIndex)} style={{marginTop: '5%'}}>
              Добавить вариант ответа
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
