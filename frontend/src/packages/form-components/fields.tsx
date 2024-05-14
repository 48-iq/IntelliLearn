import { Input, InputProps, Select, SelectProps } from "antd"
import { ConnectedField } from "effector-forms"
import { ReactNode, useEffect } from "react"
import styled from "styled-components"

function Label({ label, required }: { label?: ReactNode, required?: boolean }) {
  return (label ?
    <LabelStyled>
      {label}
      {required && <span style={{ color: "red" }}>*</span>}
    </LabelStyled>
    : <></>
  )
}

interface ErrorValidateProps {
  field: ConnectedField<any>
}

const ErrorValidate = (props: ErrorValidateProps) => {
  return (
    <div style={{ color: "red" }}>
      {props.field.errorText({
        [props.field.name]: "props.errorText",
      })}
    </div>
  )
}

interface FieldProps<T> {
  field?: ConnectedField<T>
  setValueField?: T
  errorText?: any
  label?: ReactNode | string
  required?: boolean
  visibilityToggle?: boolean
}

export interface InputFieldProps<T extends string | number | undefined | null> extends FieldProps<T>, InputProps { }

export function InputField<T extends string | number | undefined | null>(props: InputFieldProps<T>) {
  useEffect(() => {
    if (props.setValueField)
      props.field?.set(props.setValueField)
  }, [props.setValueField])

  return (
    <FieldWithLabelColumn>
      <Label label={props.label} required={props.required} />
      <Input
        value={props.field && props?.field.value || ""}
        onChange={(e) => props.field && props.field.onChange(e.target.value as T)}
        {...props}
      />
      {props.field && <ErrorValidate field={props.field} />}
    </FieldWithLabelColumn>
  )
}

export const enumToOptions = (_enum: any) => {
  return Object.entries(_enum).map((option) => {
    return { value: String(option[1]), label: String(option[1]) }
  })
}

export interface SelectFieldProps<T> extends SelectProps, FieldProps<T> {
}

export function SelectField<T>(props: SelectFieldProps<T>) {
  useEffect(() => {
    if (props.setValueField)
      props.field?.set(props.setValueField)
  }, [props.setValueField])

  return (
    <FieldWithLabelColumn>
      <Label label={props.label} required={props.required} />
      <Select
        bordered
        allowClear
        showSearch
        defaultActiveFirstOption
        value={props.mode === 'multiple' && props.field && props.field.value !== null ? props.field && props.field.value : props.mode !== 'multiple' ? props.field && props.field.value : undefined}
        // @ts-ignore
        onChange={(value: any, option: any) => {
          props.field && props.field.onChange(value as any)
          if (props.onChange) props.onChange(value, option)
        }}
        options={props.options}
        {...props}
      />
      {props.field && <ErrorValidate field={props.field} />}
    </FieldWithLabelColumn>
  )
}

const LabelStyled = styled.label`
  display: flex;
  gap: 10px;
  margin-bottom: 4px;
`;
const FieldWithLabelColumn = styled.div`
  position: relative;
  width: 100%;
  display: flex;
  flex-direction: column;
  gap: 0 10px;
`