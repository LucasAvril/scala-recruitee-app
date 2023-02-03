package com.citreum.recruitee-app

import org.scalatra.test.scalatest._

class RecAppTests extends ScalatraFunSuite {

  addServlet(classOf[RecApp], "/*")

  test("GET / on RecApp should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
