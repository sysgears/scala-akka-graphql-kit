package modules.mail.service.ethereal

import akka.actor.ActorRef
import akka.stream.ActorMaterializer
import com.github.jurajburian.mailer.{Mailer, Message}
import common.ActorUtil
import javax.inject.{Inject, Named}
import modules.mail.actor.MailActor
import modules.mail.models.{MailPayload, SendMail}
import modules.mail.service.MailService

import scala.concurrent.{ExecutionContext, Future}

class EtherealMailService @Inject()(@Named(MailActor.name) mailActor: ActorRef,
                                    @Named("ethereal") mailer: Mailer)
                                   (implicit executionContext: ExecutionContext,
                                    materializer: ActorMaterializer) extends MailService[Message, MailPayload]
  with ActorUtil {

  def sent(message: Message): Future[MailPayload] = {
    sendMessageToActor[MailPayload](actorRef => mailActor ! SendMail(message, mailer, actorRef))
  }
}