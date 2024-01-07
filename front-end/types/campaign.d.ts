import { Biro } from "~/types/biro";
import { CampaignMedia } from "~/types/campaign-media";
import { CampaignObjective } from "~/types/campaign-objective";
import { CampaignType } from "~/types/campaign-type";
import { Category } from "~/types/category";
import { Channel } from "~/types/channel";
import { Division } from "~/types/division";
import { Language } from "~/types/language";
import { Product } from "~/types/product";
import { RequestSource } from "~/types/request-source";
import { RequestStatus } from "~/types/request-status";

export interface Campaign {
  id?: number
  createdDate?: string
  modifiedDate?: string
  modifiedTime?: any
  modifiedBy?: any
  blastRecipient?: string
  username?: string
  divisionId?: number
  division?: Division
  biroId?: number
  biro?: Biro
  channelId?: number
  channel?: Channel
  campaignName?: string
  campaignDetail?: string
  productId?: number
  product?: Product
  merchantName?: string
  merchantBusinessType?: string
  campaignLocation?: string
  textHeader?: string
  templateBody?: string
  templateAdditionalInfo?: string
  textFooter?: string
  buttonType1?: string
  buttonTitle1?: string
  buttonValue1?: string
  buttonType2?: string
  buttonTitle2?: string
  buttonValue2?: string
  buttonType3?: string
  buttonTitle3?: string
  campaignMediaId?: number | null
  campaignMedia?: CampaignMedia
  mediaFile?: string
  totalBlast?: number | null
  startDate?: string
  endDate?: string
  audienceCriteria?: string
  audienceFile?: string
  picContact?: string
  additionalContact?: string
  additionalInfo?: string
  pic1?: string
  pic2?: string
  pic3?: string
  rejectReasonManager?: string
  rejectReasonTraffic?: string
  rejectReasonCmSpv?: string
  rejectReasonWaTeam?: string
  categoryId?: number
  category?: Category
  campaignTypeId?: number 
  campaignType?: CampaignType
  campaignObjectiveId?: number
  campaignObjective?: CampaignObjective
  languageId?: number
  language?: Language
  templateName?: string
  requestStatusId?: number
  requestStatus?: RequestStatus
  blastCanceled?: number
  requestSourceId?: number
  requestSource?: RequestSource
  templateId?: number
  createdTemplateDate?: string
  modifiedTemplateDate?: string
  periodBlast?: string
  headerType?: string
  mediaType?: string
  isContentMarketing?: string
  isBlastMarketing?: string
  wording?: string
}
