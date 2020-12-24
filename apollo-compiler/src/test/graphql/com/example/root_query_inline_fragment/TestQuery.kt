// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.root_query_inline_fragment

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
import com.example.root_query_inline_fragment.adapter.TestQuery_ResponseAdapter
import com.example.root_query_inline_fragment.type.Episode
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
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
  interface Data : Operation.Data {
    val __typename: String

    override fun marshaller(): ResponseFieldMarshaller

    interface Query : Data {
      override val __typename: String

      val hero: Hero?

      val droid: Droid?

      override fun marshaller(): ResponseFieldMarshaller

      /**
       * A character from the Star Wars universe
       */
      interface Hero {
        val __typename: String

        /**
         * The name of the character
         */
        val name: String

        /**
         * The movies this character appears in
         */
        val appearsIn: List<Episode?>

        fun marshaller(): ResponseFieldMarshaller

        interface Human : Hero {
          override val __typename: String

          /**
           * The name of the character
           */
          override val name: String

          /**
           * The movies this character appears in
           */
          override val appearsIn: List<Episode?>

          /**
           * Height in the preferred unit, default is meters
           */
          val height: Double?

          override fun marshaller(): ResponseFieldMarshaller
        }

        companion object {
          fun Hero.asHuman(): Human? = this as? Human
        }
      }

      /**
       * An autonomous mechanical character in the Star Wars universe
       */
      interface Droid {
        val __typename: String

        fun marshaller(): ResponseFieldMarshaller

        interface Droid : Query.Droid {
          override val __typename: String

          /**
           * What others call this droid
           */
          val name: String

          /**
           * This droid's primary function
           */
          val primaryFunction: String?

          override fun marshaller(): ResponseFieldMarshaller
        }

        companion object {
          fun Query.Droid.asDroid(): Droid? = this as? Droid
        }
      }
    }

    data class QueryDatum(
      override val __typename: String,
      override val hero: Hero?,
      override val droid: Droid?
    ) : Data, Query {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          TestQuery_ResponseAdapter.Data.QueryDatum.toResponse(writer, this)
        }
      }

      /**
       * A character from the Star Wars universe
       */
      interface Hero : Query.Hero {
        override val __typename: String

        /**
         * The name of the character
         */
        override val name: String

        /**
         * The movies this character appears in
         */
        override val appearsIn: List<Episode?>

        override fun marshaller(): ResponseFieldMarshaller

        interface Human : Query.Hero, Query.Hero.Human {
          override val __typename: String

          /**
           * The name of the character
           */
          override val name: String

          /**
           * The movies this character appears in
           */
          override val appearsIn: List<Episode?>

          /**
           * Height in the preferred unit, default is meters
           */
          override val height: Double?

          override fun marshaller(): ResponseFieldMarshaller
        }

        data class HumanHero(
          override val __typename: String,
          /**
           * The name of the character
           */
          override val name: String,
          /**
           * The movies this character appears in
           */
          override val appearsIn: List<Episode?>,
          /**
           * Height in the preferred unit, default is meters
           */
          override val height: Double?
        ) : Query.Hero, Query.Hero.Human, Human, Hero {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestQuery_ResponseAdapter.Data.QueryDatum.Hero.HumanHero.toResponse(writer, this)
            }
          }
        }

        data class OtherHero(
          override val __typename: String,
          /**
           * The name of the character
           */
          override val name: String,
          /**
           * The movies this character appears in
           */
          override val appearsIn: List<Episode?>
        ) : Query.Hero, Hero {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestQuery_ResponseAdapter.Data.QueryDatum.Hero.OtherHero.toResponse(writer, this)
            }
          }
        }

        companion object {
          fun Hero.asHero(): Query.Hero? = this as? Query.Hero

          fun Hero.asHuman(): Human? = this as? Human
        }
      }

      /**
       * An autonomous mechanical character in the Star Wars universe
       */
      interface Droid : Query.Droid {
        override val __typename: String

        override fun marshaller(): ResponseFieldMarshaller

        interface Droid : Query.Droid, Query.Droid.Droid {
          override val __typename: String

          /**
           * What others call this droid
           */
          override val name: String

          /**
           * This droid's primary function
           */
          override val primaryFunction: String?

          override fun marshaller(): ResponseFieldMarshaller
        }

        data class DroidDroid(
          override val __typename: String,
          /**
           * What others call this droid
           */
          override val name: String,
          /**
           * This droid's primary function
           */
          override val primaryFunction: String?
        ) : Query.Droid, Query.Droid.Droid, Droid, QueryDatum.Droid {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestQuery_ResponseAdapter.Data.QueryDatum.Droid.DroidDroid.toResponse(writer, this)
            }
          }
        }

        data class OtherDroid(
          override val __typename: String
        ) : Query.Droid, QueryDatum.Droid {
          override fun marshaller(): ResponseFieldMarshaller {
            return ResponseFieldMarshaller { writer ->
              TestQuery_ResponseAdapter.Data.QueryDatum.Droid.OtherDroid.toResponse(writer, this)
            }
          }
        }

        companion object {
          fun QueryDatum.Droid.asDroid(): Droid? = this as? Droid
        }
      }
    }

    data class OtherDatum(
      override val __typename: String
    ) : Data {
      override fun marshaller(): ResponseFieldMarshaller {
        return ResponseFieldMarshaller { writer ->
          TestQuery_ResponseAdapter.Data.OtherDatum.toResponse(writer, this)
        }
      }
    }

    companion object {
      fun Data.asQuery(): Query? = this as? Query
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "25584d760eab0f41189b9f2bbdbba3c0ec491aced65ef23924ecdc8f41ffe78c"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  __typename
          |  ... on Query {
          |    __typename
          |    hero {
          |      __typename
          |      name
          |      appearsIn
          |      ... on Human {
          |        height
          |      }
          |    }
          |    droid(id: 1) {
          |      __typename
          |      ... on Droid {
          |        name
          |        primaryFunction
          |      }
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
