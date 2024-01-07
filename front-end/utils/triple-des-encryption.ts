import * as crypto from 'crypto'

export default class TripleDESEncoder {
  private static readonly HEX_DIGITS = '0123456789ABCDEF'
  private desKey: Buffer | null = null

  constructor(key: Buffer) {
    this.createCipher(key)
  }

  private createCipher(desKeyData: Buffer): void {
    try {
      if (!(desKeyData.length === 16 || desKeyData.length === 24)) {
        return
      }
      const key = Buffer.alloc(24)
      if (desKeyData.length === 16) {
        desKeyData.copy(key, 0, 0, 16)
        desKeyData.copy(key, 16, 0, 8)
      }
      if (desKeyData.length === 24) {
        desKeyData.copy(key, 0, 0, 24)
      }
      const desKeySpec = key
      this.desKey = desKeySpec
    } catch (ignored) {}
  }

  public encryptECB(cleartext: Buffer): Buffer | null {
    try {
      if (!this.desKey) {
        return null
      }
      const desCipher = crypto.createCipheriv(
        'des-ede3-cbc',
        this.desKey,
        Buffer.alloc(8)
      )
      return Buffer.concat([desCipher.update(cleartext), desCipher.final()])
    } catch (ignored) {
      return null
    }
  }

  private toHexString(b: Buffer): string {
    if (!b || b.length === 0) {
      return ''
    }
    return Array.from(
      b,
      (byte) =>
        TripleDESEncoder.HEX_DIGITS.charAt((byte & 0xff) >> 4) +
        TripleDESEncoder.HEX_DIGITS.charAt(byte & 0xf)
    ).join('')
  }

  public padData(orig: string): string {
    const buff = Buffer.from(orig, 'utf-8')
    let padSize = 0
    if (buff.length % 8 !== 0) {
      padSize = 8 - (buff.length % 8)
    }
    const padding = Buffer.alloc(padSize, 0x00)
    return Buffer.concat([buff, padding]).toString('utf-8')
  }

  public encrypt(data: string): string {
    if (!this.desKey) {
      return ''
    }
    const paddedData = this.padData(data)
    const encrypted = this.encryptECB(Buffer.from(paddedData, 'utf-8'))
    return encrypted ? this.toHexString(encrypted).slice(0, 16) : ''
  }
}
