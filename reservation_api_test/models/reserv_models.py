from odoo import models, fields


class Reserv(models.Model):
    _name = 'my_custom_module.reserv'
    _description = 'Reservation Entity'

    no_reservasi = fields.Char(string='No Reservasi', required=True, size=12)
    no_pendaftaran = fields.Char(string='No Pendaftaran', required=True, size=12)
    kd_poli = fields.Char(string='Kd Poli', size=2)
    norm = fields.Char(string='Norm', size=8)
    tgl_reservasi = fields.Datetime(string='Tgl Reservasi')
    tgl_daftar = fields.Datetime(string='Tgl Daftar')
    no_urut = fields.Char(string='No Urut', size=7)
    nama = fields.Char(string='Nama', size=35)
    kd_dokter = fields.Char(string='Kd Dokter', size=7)
    kd_caramasuk = fields.Char(string='Kd Caramasuk', size=2)
    nm_telp = fields.Char(string='Nm Telp', size=35)
    no_telp1 = fields.Char(string='No Telp1', size=20)
    sts_batal = fields.Boolean(string='Sts Batal')
    sts_pagi = fields.Boolean(string='Sts Pagi')
    kd_jns_carabayar = fields.Char(string='Kd Jns Carabayar', size=2)
    kd_bayar = fields.Char(string='Kd Bayar', size=3)
    modified_by = fields.Char(string='Modified By')
    modified_at = fields.Datetime(string='Modified At', readonly=True, auto_now=True)