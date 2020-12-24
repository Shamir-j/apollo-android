// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.simple_inline_fragment

import com.apollographql.apollo.api.CustomScalarAdapters
import com.apollographql.apollo.api.CustomScalarAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.simple_inline_fragment.adapter.TestQuery_ResponseAdapter
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class TestQuery : Query<TestQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID

  override fun queryDocument(): String = QUERY_DOCUMENT

  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES

  override fun name(): OperationName = OPERATION_NAME

  override fun responseFieldMapper(): ResponseFieldMapper<Data> {
    return ResponseFieldMapper { reader ->
      TestQuery_ResponseAdapter.fromResponse(reader)
    }
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, customScalarAdapters: CustomScalarAdapters):
      Response<Data> {
    return SimpleOperationResponseParser.parse(source, this, customScalarAdapters)
  }

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, customScalarAdapters: CustomScalarAdapters):
      Response<Data> {
    return parse(Buffer().write(byteString), customScalarAdapters)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> {
    return parse(source, DEFAULT)
  }

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> {
    return parse(byteString, DEFAULT)
  }

  override fun composeRequestBody(customScalarAdapters: CustomScalarAdapters): ByteString {
    return OperationRequestBodyComposer.compose(
      operation = this,
      autoPersistQueries = false,
      withQueryDocument = true,
      customScalarAdapters = customScalarAdapters
    )
  }

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    customScalarAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    customScalarAdapters: CustomScalarAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    customScalarAdapters = customScalarAdapters
  )

  /**
   * The query type, represents all of the entry points into our object graph
   */
  data class Data(
    val hero: Hero?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        TestQuery_ResponseAdapter.Data.toResponse(writer, this)
      }
    }

    /**
     * A character from the Star Wars universe
     */
    interface Hero {
      val __typename: String

      fun marshaller(): ResponseFieldMarshaller

      interface Character : Hero {
        override val __typename: String

        /**
         * The name of the character
         */
        val name: String

        override fun marshaller(): ResponseFieldMarshaller
      }

      interface Human : Hero {
        override val __typename: String

        /**
         * Height in the preferred unit, default is meters
         */
        val height: Double?

        override fun marshaller(): ResponseFieldMarshaller
      }

      interface Droid : Hero {
        override val __typename: String

        /**
         * This droid's primary function
         */
        val primaryFunction: String?

        override fun marshaller(): ResponseFieldMarshaller
      }

      data class CharacterDroidHero(
        override val __typename: String,
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * This droid's primary function
         */
        override val primaryFunction: String?
      ) : Hero, Character, Droid {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestQuery_ResponseAdapter.Data.Hero.CharacterDroidHero.toResponse(writer, this)
          }
        }
      }

      data class CharacterHumanHero(
        override val __typename: String,
        /**
         * The name of the character
         */
        override val name: String,
        /**
         * Height in the preferred unit, default is meters
         */
        override val height: Double?
      ) : Hero, Character, Human {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestQuery_ResponseAdapter.Data.Hero.CharacterHumanHero.toResponse(writer, this)
          }
        }
      }

      data class OtherHero(
        override val __typename: String
      ) : Hero {
        override fun marshaller(): ResponseFieldMarshaller {
          return ResponseFieldMarshaller { writer ->
            TestQuery_ResponseAdapter.Data.Hero.OtherHero.toResponse(writer, this)
          }
        }
      }

      companion object {
        fun Hero.asCharacter(): Character? = this as? Character

        fun Hero.asHuman(): Human? = this as? Human

        fun Hero.asDroid(): Droid? = this as? Droid
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "5474e96626eb1bd3adbb1a3bc28419597638a648778d634ed80a485b9586ec89"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  hero {
          |    __typename
          |    ... on Character {
          |      name
          |    }
          |    ... on Human {
          |      height
          |    }
          |    ... on Droid {
          |      primaryFunction
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String {
        return "TestQuery"
      }
    }
  }
}
