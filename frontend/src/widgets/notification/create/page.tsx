import React, { useState } from 'react';
import { InputField, SelectField, enumToOptions } from "@/packages/form-components/fields";
import { Button, Form, Space } from "antd";
import { Content } from "antd/es/layout/layout";
import styled from "styled-components";
import { TitleCustom } from "@/packages/title";

export const CreateNotification = () => {
    const students = [
        { id: 1, name: 'Студент 1' },
        { id: 2, name: 'Студент 2' },
      ];
      
      const groups = [
        { id: 1, name: 'Группа 1' },
        { id: 2, name: 'Группа 2' },
      ];

    const [formState, setFormState] = useState({
        message: '',
        recipientType: '', // 'student' или 'group'
        recipientId: null, // ID студента или группы
    });

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        console.log('Form values:', formState);
    };
    
    const handleInputChange = (name: string, value: string | number) => {
        setFormState(prevState => ({
          ...prevState,
            [name]: value,
        }));
    };

    return (
        <Content>
          <TitleCustom level={4}>Создание уведомления</TitleCustom>
          <Form onFinish={handleSubmit} layout="vertical">
            <InputField
              label="Сообщение"
              placeholder="Введите сообщение..."
              value={formState.message}
              onChange={(e) => handleInputChange('message', e.target.value)}
            />
            <SelectField
              label="Получатель"
              options={[
                { value: 'student', label: 'Студент' },
                { value: 'group', label: 'Группа' },
              ]}
              value={formState.recipientType}
              onChange={(value) => handleInputChange('recipientType', value)}
            />
            {formState.recipientType === 'student' && (
              <SelectField
                label="Выберите студента"
                options={students.map(student => ({ value: student.id, label: student.name }))}
                value={formState.recipientId}
                onChange={(value) => handleInputChange('recipientId', value)}
              />
            )}
            {formState.recipientType === 'group' && (
              <SelectField
                label="Выберите группу"
                options={groups.map(group => ({ value: group.id, label: group.name }))}
                value={formState.recipientId}
                onChange={(value) => handleInputChange('recipientId', value)}
              />
            )}
            <Button type="primary" htmlType="submit">Отправить</Button>
          </Form>
        </Content>
      );
}
