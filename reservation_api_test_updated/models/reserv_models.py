from odoo import models, fields
from odoo import http
import requests


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

    class ReservationController(http.Controller):
        @http.route('/odoo_rest_module/reservation', type='json', auth='public', methods=['POST'])
        def create_reservation(self, **post):
            no_reservasi = post.get('no_reservasi')
            no_pendaftaran = post.get('no_pendaftaran')
            kd_poli = post.get('no_kd_poli')
            norm = post.get('norm')
            tgl_reservasi = post.get('tgl_reservasi')
            tgl_daftar = post.get('tgl_daftar')
            no_urut = post.get('no_urut')
            nama = post.get('nama')
            kd_dokter = post.get('kd_dokter')
            kd_caramasuk = post.get('kd_caramasuk')
            nm_telp = post.get('nm_telp')
            no_telp1 = post.get('no_telp1')
            sts_batal = post.get('sts_batal')
            sts_pagi = post.get('sts_pag')
            kd_jns_carabayar = post.get('kd_jns_carabayar')
            kd_bayar = post.get('kd_bayar')
            modified_by = post.get('modified_by')
            modified_at = post.get('modified_at')

            payload = {
                'NO_RESERVASI': no_reservasi,
                'NO_PENDAFTARAN': no_pendaftaran,
                'KD_POLI': kd_poli,
                'NORM': norm,
                'TGL_RESERVASI': tgl_reservasi,
                'TGL_DAFTAR': tgl_daftar,
                'NO_URUT': no_urut,
                'NAMA': nama,
                'KD_DOKTER': kd_dokter,
                'KD_CARAMASUK': kd_caramasuk,
                'NM_TELP': nm_telp,
                'NO_TELP': no_telp1,
                'STS_BATAL': sts_batal,
                'STS_PAGI': sts_pagi,
                'KD_JNS_CARABAYAR': kd_jns_carabayar,
                'KD_BAYAR': kd_bayar,
                'MODIFIEDBY': modified_by,
                'MODIFIEDAT': modified_at,
            }

            api_endpoint = 'http://localhost:8080/api/reservation'
            response = requests.post(api_endpoint, json=payload)
            if response.status_code == 201:
                result = response.json()
                return {'success': True, 'message': 'Reservation created successfully.'}
            else:
                error_message = response.json().get('message', 'Unknown error occurred.')
                return {'success': False, 'message': error_message}
