package com.citreum.recruiteeapp

import org.scalatra._
import org.kohsuke.github._
import com.citreum.recruiteeapp.Test.{
  GITHUB_PRIVATE_KEY,
  GITHUB_WEBHOOK_SECRET,
  GITHUB_APP_IDENTIFIER
}
import io.circe.parser.parse
import io.really.jwt._
import java.time._

class GHApp extends ScalatraServlet {

  val PRIVATE_KEY = GITHUB_PRIVATE_KEY
  val WEBHOOK_SECRET = GITHUB_WEBHOOK_SECRET
  val APP_IDENTIFIER = GITHUB_APP_IDENTIFIER

  get("/") {
    views.html.hello()
  }

  before("/event_handler") {
    //TODO initialise everything
    /*
    get_payload_request(request)
    verify_webhook_signature
    authenticate_app
    authenticate_installation(@payload)
     */
  }

  post("/event_handler") {
    //TODO listen to issues
    /*
    case request.env['HTTP_X_GITHUB_EVENT']
    when 'issues'
      if @payload['action'] === 'opened'
        handle_issue_opened_event(@payload)
      end
    end
    200
  end
     */
  }

  def handle_issue_opened_event(payload: GHEventPayload): Unit = {
    val issue_name = payload["issue"]["title"]
    //TODO kohsuke create repo
    val repo_name = s"Citreum/$issue_name"
    //TODO kohsuke invite user
  }

  def get_payload_request(request: GitHubRequest): Unit = {
    val payload_raw = request.body.read.toString
    try {
      val payload = parse(payload_raw)
    } catch {
      case error: Error =>
        println(s"Invalid JSON ($error): $payload_raw")
    }
  }

  def authenticate_app: Unit = {
    val payload = { //TODO Huge issue
      iat: LocalTime
      exp: LocalTime + (10 * 60)
      iss: APP_IDENTIFIER
    }

    val jwt = JWT.encodeWithoutSecret(payload, PRIVATE_KEY, "RS256")

    val app_client = createToken(jwt) //TODO Kohsuke create client and token
  }

  def authenticate_installation(payload: GHEventPayload): Unit = {
    val installation_id = payload["installation"]["id"]
    /*
    @installation_token = @app_client.create_app_installation_access_token(@installation_id)[:token]
    @installation_client = Octokit::Client.new(bearer_token: @installation_token)
     */
  }

  def verify_webhook_signature: Unit = {
    //TODO
    /*
    their_signature_header = request.env['HTTP_X_HUB_SIGNATURE'] || 'sha1='
    method, their_digest = their_signature_header.split('=')
    our_digest = OpenSSL::HMAC.hexdigest(method, WEBHOOK_SECRET, @payload_raw)
    halt 401 unless their_digest == our_digest

    logger.debug "---- received event #{request.env['HTTP_X_GITHUB_EVENT']}"
    logger.debug "----    action #{@payload['action']}" unless @payload['action'].nil?
     */
  }
}
