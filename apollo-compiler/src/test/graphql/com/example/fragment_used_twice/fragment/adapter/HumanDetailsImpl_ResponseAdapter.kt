// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_used_twice.fragment.adapter

import com.apollographql.apollo.api.CustomScalar
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.fragment_used_twice.fragment.HumanDetailsImpl
import com.example.fragment_used_twice.type.DATE
import kotlin.Any
import kotlin.Array
import kotlin.String

object HumanDetailsImpl_ResponseAdapter : ResponseAdapter<HumanDetailsImpl> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forString("__typename", "__typename", null, false, null),
    ResponseField.forString("name", "name", null, false, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): HumanDetailsImpl {
    val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
    return when(typename) {
      "Human" -> CharacterHumanDetailsImpl.fromResponse(reader, typename)
      else -> OtherHumanDetailsImpl.fromResponse(reader, typename)
    }
  }

  override fun toResponse(writer: ResponseWriter, value: HumanDetailsImpl) {
    when(value) {
      is HumanDetailsImpl.CharacterHumanDetailsImpl -> CharacterHumanDetailsImpl.toResponse(writer, value)
      is HumanDetailsImpl.OtherHumanDetailsImpl -> OtherHumanDetailsImpl.toResponse(writer, value)
    }
  }

  object CharacterHumanDetailsImpl : ResponseAdapter<HumanDetailsImpl.CharacterHumanDetailsImpl> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null),
      ResponseField.forCustomScalar("birthDate", "birthDate", null, false, CustomScalar.DATE, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        HumanDetailsImpl.CharacterHumanDetailsImpl {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        var birthDate: Any? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            2 -> birthDate = readCustomScalar<Any>(RESPONSE_FIELDS[2] as ResponseField.CustomScalarField)
            else -> break
          }
        }
        HumanDetailsImpl.CharacterHumanDetailsImpl(
          __typename = __typename!!,
          name = name!!,
          birthDate = birthDate!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter,
        value: HumanDetailsImpl.CharacterHumanDetailsImpl) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
      writer.writeCustom(RESPONSE_FIELDS[2] as ResponseField.CustomScalarField, value.birthDate)
    }
  }

  object OtherHumanDetailsImpl : ResponseAdapter<HumanDetailsImpl.OtherHumanDetailsImpl> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("name", "name", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        HumanDetailsImpl.OtherHumanDetailsImpl {
      return reader.run {
        var __typename: String? = __typename
        var name: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> name = readString(RESPONSE_FIELDS[1])
            else -> break
          }
        }
        HumanDetailsImpl.OtherHumanDetailsImpl(
          __typename = __typename!!,
          name = name!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: HumanDetailsImpl.OtherHumanDetailsImpl) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.name)
    }
  }
}
