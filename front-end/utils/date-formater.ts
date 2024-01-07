import moment from 'moment';

export function formatedDate(dateString: string) {
  const date = new Date(dateString)
  return moment(date).format("DD MMM yyyy")
}

export function dateToString(date: Date) {
  return `${String(date.getMonth()+1).padStart(2, '0')}/${date.getDate()}/${date.getFullYear()}`
}

export function getMonthFromDate(month: number) {
  return monthString[month]
}

const monthString = [
  'Jan',
  'Feb',
  'Mar',
  'Apr',
  'May',
  'Jun',
  'Jul',
  'Aug',
  'Sep',
  'Oct',
  'Nov',
  'Des'
]
